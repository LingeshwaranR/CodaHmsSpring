package global.coda.hms.mapper;

import java.util.List;

import global.coda.hms.model.Patient;
import global.coda.hms.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface PatientMapper {
    //CREATE PATIENT
    @Insert("insert into t_user(username,email,password,fk_role_id) values(#{username},#{email},#{password},2)")
    @Options(useGeneratedKeys = true, keyProperty = "pk_user_id",keyColumn = "pk_user_id")
    void createUser(Patient patient);
    @Insert("insert into t_patient(age,area,city,state,fk_user_id) values(#{age},#{area},#{city},#{state},#{pk_user_id})")
    void createPatient(Patient patient);
    //READ ALL
    @Select("select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where t_user.is_active =1 and t_patient.is_active=1")
    List<Patient> getAllPatient();
//READ PARTICULAR
    @Select("select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where  t_user.pk_user_id=#{id} and   t_user.is_active =1 and t_patient.is_active=1")
    Patient getById(int id);

}

package global.coda.hms.mapper;

import java.util.List;

import global.coda.hms.model.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



/**
 * The interface Patient mapper.
 */
@Mapper
public interface PatientMapper {

    /**
     * Create user.
     *
     * @param patient the patient
     */
//CREATE PATIENT
    @Insert("insert into t_user(username,email,password,fk_role_id) values(#{username},#{email},#{password},2)")
    @Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
    void createUser(Patient patient);

    /**
     * Create patient.
     *
     * @param patient the patient
     */
    @Insert("insert into t_patient(age,area,city,state,fk_user_id) values(#{age},#{area},#{city},#{state},#{pkUserId})")
    void createPatient(Patient patient);

    /**
     * Gets all patient.
     *
     * @return the all patient
     */
//READ ALL
    @Select("select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where t_user.is_active =1 and t_patient.is_active=1")
    List<Patient> getAllPatient();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
//READ PARTICULAR
    @Select("select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where  t_user.pk_user_id=#{id} and   t_user.is_active =1 and t_patient.is_active=1")
    Patient getById(int id);

    /**
     * Update user.
     *
     * @param patient the patient
     */
//UPDATE PATIENT
    @Update("update t_user set username=#{username},email=#{email},password=#{password} where pk_user_id=#{pkUserId} and is_active=1")
    void updateUser(Patient patient);

    /**
     * Update patient.
     *
     * @param patient the patient
     */
    @Update("update t_patient set age=#{age},area=#{area},city=#{city},state=#{state} where fk_user_id=#{pkUserId} and is_active=1")
    void updatePatient(Patient patient);

    /**
     * Delete user.
     *
     * @param patient the patient
     */
//DELETE PATIENT
    @Update("update t_user set is_active =0 where pk_user_id=#{pkUserId}")
    void deleteUser(Patient patient);

    /**
     * Delete patient.
     *
     * @param patient the patient
     */
    @Update("update t_patient set is_active=0 where fk_user_id=#{pkUserId}")
    void deletePatient(Patient patient);

}

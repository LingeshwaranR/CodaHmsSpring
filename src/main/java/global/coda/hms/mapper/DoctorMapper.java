package global.coda.hms.mapper;

import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * The interface Doctor mapper.
 */
@Mapper
public interface DoctorMapper {
    /**
     * Create user.
     *
     * @param doctor the doctor
     */
//CREATE DOCTOR
    @Insert("insert into t_user(username,email,password,fk_role_id) values(#{username},#{email},#{password},2)")
    @Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
    void createUser(Doctor doctor);

    /**
     * Create doctor.
     *
     * @param doctor the doctor
     */
    @Insert("insert into t_doctor(specialist,fk_user_id) values(#{specialist},#{pkUserId})")
    void createDoctor(Doctor doctor);

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
//READ ALL
    @Select("select pk_user_id,username,email,password,fk_role_id,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where   t_user.is_active=1 and t_doctor.is_active=1")
    List<Doctor> getAllDoctors();

    /**
     * Gets doctor by id.
     *
     * @param id the id
     * @return the doctor by id
     */
//READ PARTICULAR
    @Select("select pk_user_id,username,email,password,fk_role_id,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.pk_user_id= #{id} and  t_user.is_active=1 and t_doctor.is_active=1")
    Doctor getDoctorById(int id);

    /**
     * Update user.
     *
     * @param doctor the doctor
     */
//UPDATE DOCTOR
    @Update("update t_user set username=#{username},email=#{email},password=#{password} where pk_user_id=#{pkUserId} and is_active=1")
    void updateUser(Doctor doctor);

    /**
     * Update doctor.
     *
     * @param doctor the doctor
     */
    @Update("update t_doctor set specialist=#{specialist} where fk_user_id=#{pkUserId} and is_active=1")
    void updateDoctor(Doctor doctor);

    /**
     * Delete user.
     *
     * @param doctor the doctor
     */
//DELETE DOCTOR
    @Update("update t_user set is_active =0 where pk_user_id=#{pkUserId}")
    void deleteUser(Doctor doctor);

    /**
     * Delete doctor.
     *
     * @param doctor the doctor
     */
    @Update("update t_doctor set is_active=0 where fk_user_id=#{pkUserId}")
    void deleteDoctor(Doctor doctor);

    /**
     * Gets patient under a doctor.
     *
     * @param id the id
     * @return the patient under a doctor
     */
//PATIENT LIST UNDER A DOCTOR
    @Select("select pk_user_id,username,email,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id join t_patient_has_doctor on t_patient_has_doctor.fk_patient_id = t_user.pk_user_id  where t_user.is_active =1 and t_patient.is_active=1 and t_patient_has_doctor.is_active=1 and t_patient_has_doctor.fk_doctor_id=#{id}")
    List<Patient> getPatientUnderADoctor(int id);

    /**
     * Gets all patient under all doctors.
     *
     * @return the all patient under all doctors
     */
//PATIENT LIST UNDER ALL DOCTOR
    @Select("<script> select pk_user_id,username,email,password,fk_role_id,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.is_active=1 and t_doctor.is_active=1 <if test='id !=0'> and  pk_user_id=#{id} </if> </script>")
    @Results(value = {
            @Result(property="pkUserId", column="pk_user_id"),
            @Result(property="username", column="username"),
            @Result(property="email", column="email"),
            @Result(property="password", column="password"),
            @Result(property="specialist", column="specialist"),
            @Result(property="fkRoleId", column="fk_role_id"),
            @Result(property="patientList", javaType=List.class, column="pk_user_id",
                    many=@Many(select  ="getPatientUnderADoctor"))
    })
    List<Doctor> getAllPatientUnderAllDoctors(int id);




}


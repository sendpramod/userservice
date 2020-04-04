package com.demo.userservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"emailId", "mobileNo"}))
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userId;
    @NotEmpty
    private String name;
    private Gender gender;
    private String emailId;
    @NotEmpty
    private String mobileNo;
    private Date creationTime;
    private Date updationTime= Calendar.getInstance().getTime();
}

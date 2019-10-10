package gitchat.annotation.entity;

import gitchat.annotation.anno.GenDTO;
import gitchat.annotation.anno.GenDTOIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yanyuchi
 * @date 2019-07-15 15:50
 */
@GenDTO(pkgName = "gitchat.annotation.dto")
public class Person {

    private String name;

    private Long id;

    private Integer age;

    private Date birthday;

    @GenDTOIgnore
    private List<String> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @GenDTOIgnore
    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}

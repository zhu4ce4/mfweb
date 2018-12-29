package com.lqj.entity;

//import javax.persistence.*;

//@Entity()
//@Table(name = "critics")
public class Critics {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;
//    @Column(name = "tlid")
    private int tlid;
//    @Column(name = "criticname")
    private String criticName;
//    @Column(name = "critic")
    private String critic;

    public Critics() {
    }

    public Critics(int tlid, String criticName, String critic) {
        this.tlid = tlid;
        this.criticName = criticName;
        this.critic = critic;
    }

    public Critics(String criticName, String critic) {
        this.criticName = criticName;
        this.critic = critic;
    }

    public Critics(int id, int tlid, String criticName, String critic) {
        this.id = id;
        this.tlid = tlid;
        this.criticName = criticName;
        this.critic = critic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTlid() {
        return tlid;
    }

    public void setTlid(int tlid) {
        this.tlid = tlid;
    }

    public String getCriticName() {
        return criticName;
    }

    public void setCriticName(String criticName) {
        this.criticName = criticName;
    }

    public String getCritic() {
        return critic;
    }

    public void setCritic(String critic) {
        this.critic = critic;
    }

    @Override
    public String toString() {
        return "Critics{" +
                "id=" + id +
                ", tlid=" + tlid +
                ", criticName='" + criticName + '\'' +
                ", critic='" + critic + '\'' +
                '}';
    }
}

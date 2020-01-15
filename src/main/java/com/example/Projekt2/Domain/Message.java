package com.example.Projekt2.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Size(min = 2, message = "Too little content...")
    @Size(max = 20, message = "This is too much...")
    @NotNull(message = "Content cannot be empty")
    private String content;
    private Date createDate;
    private int id_person;

    public Message(){}

    public Message(int id, @NotEmpty String content, @NotEmpty Date createDate, int id_person) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.id_person = id_person;
    }

    public int getId(){return id;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id_person, message.id_person) &&
                Objects.equals(createDate, message.createDate) &&
                Objects.equals(content, message.content);
    }

    public String getContent() {
        return content;
    }
}

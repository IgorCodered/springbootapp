package ru.igorelesin.springbootapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30, message = "Введите минимум 2 буквы и не более 30")
    @NotNull
    private String name;

    @Size(min = 2, max = 30, message = "Введите минимум 2 буквы и не более 30")
    @NotNull
    private String surname;

    @Email
    @NotEmpty(message = "Обязательное поле")
    private String email;

}

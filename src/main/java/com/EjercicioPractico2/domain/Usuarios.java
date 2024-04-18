package com.EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
    
    public Usuarios() {
    }

    public Usuarios(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}

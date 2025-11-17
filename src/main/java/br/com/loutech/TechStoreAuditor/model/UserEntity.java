package br.com.loutech.TechStoreAuditor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class UserEntity {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
}

package ch.bbcag.backend.ticketshop.person;

import java.util.Objects;

public class PersonRequestDTO extends PersonResponseDTO{

    public String password;

    public String email;

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonRequestDTO that)) return false;
        return Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getEmail());
    }
}

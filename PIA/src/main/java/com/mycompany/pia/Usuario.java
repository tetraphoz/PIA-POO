package com.mycompany.pia;

public class Usuario {
    private String email = "";
    private String username = "";
    private String password = "";
    
    /* CONSTRUCTORES: REGISTRO Y LOGIN */
    public Usuario(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    /* MÉTODOS DE ENCAPSULACIÓN */
    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    /* MÉTODOS DE VALIDACIÓN */
    public boolean validarUsuario() {
        return validarEmail() && validarUsername() && validarPassword();
    }
    
    /* Expresión regex construida con https://regexr.com/73r3b */
    public boolean validarEmail() {
        String emailRegex = "(?=.{10,30}$)[a-zA-Z0-9_\\.]{3,}?@[a-zA-Z0-9]{3,}?\\.[a-zA-Z]{2,3}";
        if(!email.toLowerCase().matches(emailRegex))
            System.out.println("Email invalido");
        return email.toLowerCase().matches(emailRegex);
    }
    
    /* Expresión regex construida con https://regexr.com/73r81 */
    public boolean validarUsername() {
        String usernameRegex = "(?=.{5,45}$)[a-zA-Z0-9_]{5,}?";
        if(!username.matches(usernameRegex))
            System.out.println("User invalido");
        return username.matches(usernameRegex);
    }
    
    /* Expresión regex construida con https://regexr.com/73r8v */
    public boolean validarPassword() {
        String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[$%&#.\\-=:;,]).{8,16}$";
        if(!password.matches(passwordRegex))
            System.out.println("Password invalido");
        return password.matches(passwordRegex);
    }
}

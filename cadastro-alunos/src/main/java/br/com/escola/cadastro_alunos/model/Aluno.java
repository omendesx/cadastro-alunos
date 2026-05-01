package br.com.escola.cadastro_alunos.model;

public class Aluno {
    private Integer id;
    private String nome;
    private String email;
    private String curso;

    public Aluno(){

    }

    public Aluno(Integer id, String nome, String email, String curso){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }
        
    }




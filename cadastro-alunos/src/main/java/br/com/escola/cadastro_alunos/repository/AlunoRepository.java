package br.com.escola.cadastro_alunos.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import br.com.escola.cadastro_alunos.model.Aluno;

@Repository
public class AlunoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlunoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, email, curso) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, aluno.getNome(), aluno.getEmail(), aluno.getCurso());
    }

    public List<Aluno> listarTodos() {
        String sql = "SELECT id, nome, email, curso FROM alunos ORDER BY id DESC";
        return jdbcTemplate.query(sql, (resultado, numeroLinha) -> {
            Aluno aluno = new Aluno();
            aluno.setId(resultado.getInt("id"));
            aluno.setNome(resultado.getString("nome"));
            aluno.setEmail(resultado.getString("email"));
            aluno.setCurso(resultado.getString("curso"));
            return aluno;
        });

    }

    public Aluno buscarPorIdAluno(Integer id) {
        String sql = "SELECT id, nome, email, curso FROM alunos WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (resultado, numeroLinha) -> {
            Aluno aluno = new Aluno();
            aluno.setId(resultado.getInt("id"));
            aluno.setNome(resultado.getString("nome"));
            aluno.setEmail(resultado.getString("email"));
            aluno.setCurso(resultado.getString("curso"));
            return aluno;
        }, id);
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, email = ?, curso = ? WHERE id = ?";
        jdbcTemplate.update(sql, aluno.getNome(), aluno.getEmail(), aluno.getCurso(), aluno.getId());

    }

    public void excluir(Integer id){
        String sql = "DELETE FROM alunos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

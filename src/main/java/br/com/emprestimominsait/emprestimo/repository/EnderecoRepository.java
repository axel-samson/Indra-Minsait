package br.com.emprestimominsait.emprestimo.repository;

import br.com.emprestimominsait.emprestimo.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}

package br.com.emprestimominsait.emprestimo.repository;

import br.com.emprestimominsait.emprestimo.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, String> {

}

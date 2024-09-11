package com.med_api.InventarioMedfix.specifications;

import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecTemplate {
    @And({
            @Spec(path = "nome", spec = Like.class),
    })
    public interface DepartamentoSpec extends Specification<Departamento> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "descricao", spec = Like.class),
            @Spec(path = "tipo", spec = Like.class),
            @Spec(path = "memoria", spec = Like.class),
            @Spec(path = "processador", spec = Like.class),
            @Spec(path = "hd", spec = Like.class),
            @Spec(path = "sistemaOperacional", spec = Like.class),
            @Spec(path = "monitor", spec = Like.class),
            @Spec(path = "observacoes", spec = Like.class),
    })
    public interface EquipamentoSpec extends Specification<Equipamento> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
    })
    public interface UsuarioSpec extends Specification<Usuario> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
    })
    public interface FornecedorSpec extends Specification<Fornecedor> {}
}

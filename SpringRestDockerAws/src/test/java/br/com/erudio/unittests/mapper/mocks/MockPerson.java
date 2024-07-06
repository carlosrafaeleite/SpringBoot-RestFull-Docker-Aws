package br.com.erudio.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.br.carlos.data.vo.v1.PessoaVo;
import com.br.carlos.model.Pessoa;

public class MockPerson {


    public Pessoa mockEntity() {
        return mockEntity(0);
    }
    
    public PessoaVo mockVO() {
        return mockVO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PessoaVo> mockVOList() {
        List<PessoaVo> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Pessoa mockEntity(Integer number) {
    	Pessoa person = new Pessoa();
        person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setSexo(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

    public PessoaVo mockVO(Integer number) {
    	PessoaVo person = new PessoaVo();
        person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setSexo (((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

}

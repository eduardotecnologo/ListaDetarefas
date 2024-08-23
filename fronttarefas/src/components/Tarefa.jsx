import React, { useState } from 'react';
import './Tarefa.css';

function Tarefa() {

    const [tarefa, setTarefa] = useState({
            nomeTarefa: '', 
            dataInicio:'',
            dataTermino:'',
            descricaoTarefa:''
        });

    const [tarefas, setTarefas] = useState([]);
    // Estado para controlar o checkbox
    const [isChecked, setIsChecked] = useState(false);  

    function handleChange(event){
      const { name, value } = event.target;
      setTarefa({...Tarefa, [name]: value})
    }

  function handleSubmit(event){
    event.preventDefault();
    console.log(tarefa);

  setTarefas([...tarefas, {...tarefa, concluido: isChecked}]);
  // Reset Form
  setTarefa(nomeTarefa: '', dataInicio: '', dataTermino: '')
  }

  return (
    <div className="container">
      <h1>Cadastro de Tarefas</h1>
      <form onSubmit={handleSubmit}>
        <div className="col-6">
          <FormField onChange={handleChange} value={tarefa.nomeTarefa}      label="Nome da Tarefa" name="nomeTarefa" type="text" />
          <FormField onChange={handleChange} value={tarefa.dataInicio}      label="Data de Início" name="dataInicio" type="date" />
          <FormField onChange={handleChange} value={tarefa.dataTermino}     label="Data de Término" name="dataTermino" type="date" />
          <FormField onChange={handleChange} value={tarefa.descricaoTarefa} label="Descrição" name="descricaoTarefa" type="text" />
          
          <div>
            <label className="form-label">Concluído</label>
            <input
              type="checkbox"
              checked={isChecked}
              onChange={handleCheckboxChange}
              className="form-check-input"
            />
          </div>
        </div>
        <button type="submit" value="Cadastrar" className="btn btn-success mt-3">
                    Cadastrar
                </button>
      </form>
    </div>
  );
}

function FormField({ label, name, type }) {
  return (
    <div>
      <label className="form-label">{label}</label>
      <input name={name} type={type} className="form-control" />
    </div>
  );
}

export default Tarefa;

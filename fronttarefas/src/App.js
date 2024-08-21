import React, { useState } from 'react';
import './App.css';

function App() {
  // Estado para controlar o checkbox
  const [isChecked, setIsChecked] = useState(false);

  // Função para lidar com a mudança de estado do checkbox
  const handleCheckboxChange = () => {
    setIsChecked(!isChecked);
  };

  return (
    <div className="container">
      <h1>Cadastro de Tarefas</h1>
      <form>
        <div className="col-6">
          <FormField label="Nome da Tarefa" name="nomeTarefa" type="text" />
          <FormField label="Data de Início" name="dataInicio" type="date" />
          <FormField label="Data de Término" name="dataTermino" type="date" />
          <FormField label="Descrição" name="descricao" type="text" />
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

export default App;

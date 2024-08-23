import './App.css';
import Tarefa from './components/Tarefa';

function App() {


  return (
    <Tarefa/>
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

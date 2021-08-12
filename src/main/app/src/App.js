import React, { Component } from 'react';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    usuarios: []
  };

  async componentDidMount() {
    const response = await fetch('/api/usuarios');
    const body = await response.json();
    this.setState({usuarios: body.content, isLoading: false});
  }

  render() {
    const {usuarios, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <div className="App-intro">
            <h2>Lista de usuários</h2>
            {usuarios.map(usuario =>
              <div key={usuario.id}>
                {usuario.nome} - {usuario.email} - {usuario.bloqueado} - {usuario.perfilAcesso}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;
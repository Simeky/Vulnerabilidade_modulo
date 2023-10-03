const form = document.querySelector('#familia_form');
form.addEventListener('submit', (event) => {
  event.preventDefault();

  const form_data = new form_data(form);

  fetch('http://localhost:8080/familia', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      familia_nome_responsavel1: form_data.get('familia_nome_responsavel1'),
      familia_nome_responsavel2: form_data.get('familia_nome_responsavel2'),
      familia_cpf_responsavel1: form_data.get('familia_cpf_responsavel1'),
      familia_cpf_responsavel2: form_data.get('familia_cpf_responsavel2'),
      familia_qtd_filhos: form_data.get('familia_qtd_filhos'),
      familia_contato: form_data.get('familia_contato'),
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log('Registro da familia criado:', data);
    })
    .catch((error) => {
      console.error('Erro criando o registro da familia:', error);
    });
});

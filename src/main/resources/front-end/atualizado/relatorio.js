const form = document.querySelector('#relatorio_form');
form.addEventListener('submit', (event) => {
  event.preventDefault();

  const form_data = new form_data(form);

  fetch('http://localhost:8080/relatorio', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      relatorio_necessidades: form_data.get('relatorio_necessidades'),
      relatorio_renda: form_data.get('relatorio_renda'),
      relatorio_nivel_vulnerabilidade: form_data.get('relatorio_nivel_vulnerabilidade'),
      relatorio_data: form_data.get('relatorio_data'),
      relatorio_familia_id: form_data.get('relatorio_familia_id'),
      relatorio_data_visita: form_data.get('relatorio_data_visita'),
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log('Relatorio criado com sucesso:', data);
    })
    .catch((error) => {
      console.error('Erro criando o relatorio:', error);
    });
});
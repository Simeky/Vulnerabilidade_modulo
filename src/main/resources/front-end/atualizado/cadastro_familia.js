const form = document.querySelector('#familia_form');
form.addEventListener('submit', (event) => {
  event.preventDefault();

  const form_data = new form_data(form);

  fetch('http://localhost:8080/familia/Add_familia', {
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
      familia_renda: form_data.get('familia_renda'),
      familia_necessidades: form_data.get('familia_necessidades'),
      familia_nivel_vulnerabilidade: form_data.get('familia_nivel_vulnerabilidade'),
      familia_data_visita: form_data.get('familia_data_visita'),
      familia_qtd_membros: form_data.get('familia_qtd_membros'),
      familia_membros_deficiencia: form_data.get('familia_membros_deficiencia')

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

function format_cpf(input) {
  let cpf = input.value.replace(/\D/g, '');

  if (cpf.length >= 11) {
      cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  }

  input.value = cpf;
}

function format_contato(input) {
  let contato = input.value.replace(/\D/g, '');

  if (contato.length >= 10) {
      contato = contato.replace(/(\d{2})(\d{5})(\d{4})/, '($1)$2-$3');
  }

  input.value = contato;
}

function format_Renda() {
  // Obtém o valor atual da familia_renda
  var renda = document.getElementById("familia_renda").value;

  // Remove caracteres não numéricos
  renda = renda.replace(/[^\d.-]/g, '');

  // Converte para número
  var valor_numerico = parseFloat(renda);

  // Formata como moeda
  var renda_formatada = valor_numerico.toLocaleString('pt-BR', {
      style: 'currency',
      currency: 'BRL'
  });

  // Atualiza o valor no campo
  document.getElementById("familia_renda").value = renda_formatada;
}
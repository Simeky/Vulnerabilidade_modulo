const login_form = document.getElementById('#login_form');

login_form.addEventListener('submit', (event) => {
    event.preventDefault();

    const email = document.getElementById('funcionario_email').value;
    const senha = document.getElementById('funcionario_senha').value;

    const data = {
        funcionario_email: email,
        funcionario_senha: senha,
    };

    fetch('http://localhost:8080/funcionario/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then((response) => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Falha no login');
        }
    })
    .then((data) => {
        console.log('Login realizado com sucesso:', data);
    })
    .catch((error) => {
        console.error('Erro ao efetuar o login:', error);
    });
});

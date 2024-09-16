document.addEventListener('DOMContentLoaded', () => {
    // Função para mostrar a seção clicada e ocultar as outras
    function mostrarSecao(secaoId) {
        const secoes = document.querySelectorAll('.secao');
        secoes.forEach(secao => {
            if (secao.id === secaoId) {
                secao.style.display = 'block';
                carregarDados(secaoId); // Carrega dados apenas para seções que têm dados dinâmicos
            } else {
                secao.style.display = 'none';
            }
        });
    }

    // Função para carregar dados da API
    function carregarDados(secaoId) {
        const urlMap = {
            'cantores': 'http://localhost:8080/cantores',
            'musicas': 'http://localhost:8080/musicas',
            'categorias': 'http://localhost:8080/categorias',
            'gravadoras': 'http://localhost:8080/gravadoras'
        };

        const url = urlMap[secaoId];

        if (!url) return; // Não tenta carregar dados se não houver URL

        fetch(url)
            .then(response => response.json())
            .then(data => {
                let htmlContent = '';
                data.forEach(item => {
                    htmlContent += formatarItem(secaoId, item);
                });
                document.getElementById(`${secaoId}-list`).innerHTML = htmlContent;
            })
            .catch(error => {
                console.error('Erro ao carregar os dados:', error);
                document.getElementById(`${secaoId}-list`).innerHTML = '<p>Erro ao carregar dados.</p>';
            });
    }

    // Função para formatar um item com base no tipo de seção
    function formatarItem(secaoId, item) {
        let html = '<div class="item">';
        switch (secaoId) {
            case 'cantores':
                html += `<h3>${item.nomeCantor || 'Nome não disponível'}</h3>
                         <p>Pais: ${item.pais || 'Não disponível'}</p>`;
                break;
            case 'musicas':
                html += `<h3>${item.titulo || 'Título não disponível'}</h3>
                         <p>Duração: ${item.duracao ? `${item.duracao} segundos` : 'Não disponível'}</p>
                         <p>Categoria: ${item.categoria ? item.categoria.descCategoria : 'Não disponível'}</p>`;
                break;
            case 'categorias':
                html += `<h3>${item.descCategoria || 'Descrição não disponível'}</h3>`;
                break;
            case 'gravadoras':
                html += `<h3>${item.nomeGravadora || 'Nome não disponível'}</h3>`;
                break;
        }
        html += '</div>';
        return html;
    }

    // Adiciona evento de clique a cada link do menu
    document.querySelectorAll('nav a').forEach(link => {
        link.addEventListener('click', event => {
            event.preventDefault(); // Impede o comportamento padrão do link
            const secaoId = link.getAttribute('onclick').match(/'([^']+)'/)[1];
            mostrarSecao(secaoId);
        });
    });

    // Inicializa mostrando a página de introdução
    mostrarSecao('intro');
});

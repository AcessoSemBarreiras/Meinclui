package meinclui.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meinclui.modelo.dao.UsuarioTemConquista.UsuarioTemConquistaDAO;
import meinclui.modelo.dao.UsuarioTemConquista.UsuarioTemConquistaDAOImpl;
import meinclui.modelo.dao.avaliacao.AvaliacaoDAO;
import meinclui.modelo.dao.avaliacao.AvaliacaoDAOImpl;
import meinclui.modelo.dao.categoria.CategoriaDAO;
import meinclui.modelo.dao.categoria.CategoriaDAOImpl;
import meinclui.modelo.dao.comentario.ComentarioDAO;
import meinclui.modelo.dao.comentario.ComentarioDAOImpl;
import meinclui.modelo.dao.conquista.ConquistaDAO;
import meinclui.modelo.dao.conquista.ConquistaDAOImpl;
import meinclui.modelo.dao.endereco.EnderecoDAO;
import meinclui.modelo.dao.endereco.EnderecoDAOImpl;
import meinclui.modelo.dao.estabelecimento.EstabelecimentoDAO;
import meinclui.modelo.dao.estabelecimento.EstabelecimentoDAOImpl;
import meinclui.modelo.dao.usuario.UsuarioDAO;
import meinclui.modelo.dao.usuario.UsuarioDAOImpl;
import meinclui.modelo.entidade.avaliacao.Avaliacao;
import meinclui.modelo.entidade.avaliacao.AvaliacaoId;
import meinclui.modelo.entidade.categoria.Categoria;
import meinclui.modelo.entidade.comentario.Comentario;
import meinclui.modelo.entidade.endereco.Endereco;
import meinclui.modelo.entidade.estabelecimento.Estabelecimento;
import meinclui.modelo.entidade.usuario.Usuario;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AvaliacaoDAO avaliacaoDAO;
	private CategoriaDAO categoriaDAO;
	private ComentarioDAO comentarioDAO;
	private ConquistaDAO conquistaDAO;
	private EnderecoDAO enderecoDAO;
	private EstabelecimentoDAO estabelecimentoDAO;
	private UsuarioDAO usuarioDAO;
	private UsuarioTemConquistaDAO usuarioTemConquistaDAO;

	public void init() {
		avaliacaoDAO = new AvaliacaoDAOImpl();
		categoriaDAO = new CategoriaDAOImpl();
		comentarioDAO = new ComentarioDAOImpl();
		conquistaDAO = new ConquistaDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		estabelecimentoDAO = new EstabelecimentoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		usuarioTemConquistaDAO = new UsuarioTemConquistaDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {
			case "/tela-inicial":
				mostrarTelaInicial(request, response);
				break;

			case "/login-usuario":
				mostrarFormularioLogin(request, response);
				break;
			case "/cadastro-usuario":
				mostrarFormularioCadastroUsuario(request, response);
				break;
			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;
			case "/deletar-usuario":
				deletarUsuario(request, response);
				break;
			case "/atualizar-usuario":
				atualizarUsuario(request, response);
				break;
			case "/perfil-usuario":
				mostrarPerfilUsuario(request, response);
				break;
			case "/ranque-usuario":
				mostrarRanque(request, response);
				break;
			case "/editar-perfil-usuario":
				mostrarFormularioEditarUsuario(request, response);
				break;
			case "encerrar-sessao":
				encerrarSessao(request, response);
				break;

			case "/cadastro-estabelecimento":
				mostrarFormularioCadastroEstabelecimento(request, response);
				break;
			case "/inserir-estabelecimento":
				inserirEstabelecimento(request, response);
				break;
			case "/deletar-estabelecimento":
				deletarEstabelecimento(request, response);
				break;
			case "/atualizar-estabelecimento":
				atualizarEstabelecimento(request, response);
				break;
			case "/perfil-estabelecimento":
				mostrarPerfilEstabelecimento(request, response);
				break;
			case "/encontrar-estabelecimentos":
				mostrarTelaPesquisaEstabelecimento(request, response);
				break;
			case "/editar-perfil-estabelecimento":
				mostrarFormularioEditarEstabelecimento(request, response);
				break;

			case "/cadastrar-comentario":
				mostrarFormularioCadastroComentario(request, response);
				break;
			case "/inserir-comentario":
				inserirComentario(request, response);
				break;
			case "/deletar-comentario":
				deletarComentario(request, response);
				break;
			case "/atualizar-comentario":
				atualizarComentario(request, response);
				break;
			case "/recuperar-comentario":
				recuperarComentario(request, response);
				break;

			case "/avaliacao-estabelecimento":
				mostrarFormularioAvaliacaoEstabelecimento(request, response);
				break;
			case "/inserir-avaliacao":
				inserirAvaliacao(request, response);
				break;
			case "/deletar-avaliacao":
				deletarAvaliacao(request, response);
				break;
			case "/atualizar-avaliacao":
				atualizarAvaliacao(request, response);
				break;
			case "/recuperar-avaliacao":
				recuperarAvaliacao(request, response);
				break;

			case "/cadastrar-endereco":
				mostrarFormularioCadastroEndereco(request, response);
				break;
			case "/inserir-endereco":
				inserirEndereco(request, response);
				break;
			case "/deletar-endereco":
				deletarEndereco(request, response);
				break;
			case "/atualizar-endereco":
				atualizarEndereco(request, response);
				break;
			case "/recuperar-endereco":
				recuperarEndereco(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/* TELA INICIAL */
	private void mostrarTelaInicial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/* ENDEREÇO */
	private void mostrarFormularioCadastroEndereco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void recuperarEndereco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void atualizarEndereco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void deletarEndereco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void inserirEndereco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/* AVALIAÇÃO */
	private void mostrarFormularioAvaliacaoEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/avaliacao-estabelecimento");
		dispatcher.forward(request, response);
	}

	private void inserirAvaliacao(HttpServletRequest request, HttpServletResponse response) {

		Usuario usuario = Usuario.class.cast(request.getParameter("usuario"));
		Estabelecimento estabelecimento = estabelecimentoDAO
				.recuperarEstabelecimentoId(Long.parseLong(request.getParameter("estabelecimento")));
		byte resposta1 = Byte.parseByte(request.getParameter("resposta-1"));
		byte resposta2 = Byte.parseByte(request.getParameter("resposta-2"));
		byte resposta3 = Byte.parseByte(request.getParameter("resposta-3"));
		byte resposta4 = Byte.parseByte(request.getParameter("resposta-4"));
		byte resposta5 = Byte.parseByte(request.getParameter("resposta-5"));
		double media = (double) (resposta1 + resposta2 + resposta3 + resposta4 + resposta5) / 5;
		ZonedDateTime data = ZonedDateTime.now();
		avaliacaoDAO.inserirAvaliacao(new Avaliacao(usuario, estabelecimento, resposta1, resposta2, resposta3,
				resposta4, resposta5, media, data));
	}

	private void recuperarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AvaliacaoId id = AvaliacaoId.class.cast(request.getParameter("avaliacao-id"));
		Avaliacao avaliacao = avaliacaoDAO.recuperarAvaliacaoPorId(id);
		request.setAttribute("avaliacao", avaliacao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-avaliacao.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAvaliacao(HttpServletRequest request, HttpServletResponse response) {

		AvaliacaoId id = AvaliacaoId.class.cast(request.getParameter("avaliacao-id"));
		byte resposta1 = Byte.parseByte(request.getParameter("resposta-1"));
		byte resposta2 = Byte.parseByte(request.getParameter("resposta-2"));
		byte resposta3 = Byte.parseByte(request.getParameter("resposta-3"));
		byte resposta4 = Byte.parseByte(request.getParameter("resposta-4"));
		byte resposta5 = Byte.parseByte(request.getParameter("resposta-5"));
		double media = (double) (resposta1 + resposta2 + resposta3 + resposta4 + resposta5) / 5;
		ZonedDateTime dataOriginal = ZonedDateTime.parse(request.getParameter("data-original"));
		ZonedDateTime dataEdicao = ZonedDateTime.now();
		avaliacaoDAO.atualizarAvaliacao(new Avaliacao(id, resposta1, resposta2, resposta3, resposta4, resposta5, media,
				dataOriginal, dataEdicao));

	}

	private void deletarAvaliacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AvaliacaoId id = AvaliacaoId.class.cast(request.getParameter("avaliacao-id"));
		avaliacaoDAO.deletarAvaliacao(id);
		response.sendRedirect("/tela-inicial");
	}

	/* COMENTÁRIO */

	private void mostrarFormularioCadastroComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-comentario");
		dispatcher.forward(request, response);
	}

	private void recuperarComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Comentario> comentarios = comentarioDAO.recuperarComentariosPeloEstabelecimento(1);
		request.setAttribute("comentario", comentarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-estabelecimento.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String comentario = request.getParameter("comentario");
		Comentario comentarioRespondido = Comentario.class.cast(request.getParameter("comentario-respondido"));
		int qtdGostei = Integer.parseInt(request.getParameter("quantidade-gostei"));
		int qtdNaoGostei = Integer.parseInt(request.getParameter("quantidade-nao-gostei"));
		Usuario usuario = Usuario.class.cast(request.getParameter("usuario"));
		Estabelecimento estabelecimento = Estabelecimento.class.cast("estabelecimento");
		ZonedDateTime data = ZonedDateTime.class.cast("data");
		comentarioDAO.atualizarComentario(new Comentario(id, comentario, comentarioRespondido, qtdGostei, qtdNaoGostei,
				usuario, estabelecimento, data));
		response.sendRedirect("tela-inicial");

	}

	private void deletarComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-comentario"));
		comentarioDAO.deletarComentario(id);
		response.sendRedirect("tela-inicial");

	}

	private void inserirComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String comentario = request.getParameter("comentario");
		Comentario comentarioRespondido = Comentario.class.cast(request.getParameter("comentario-respondido"));
		Usuario usuario = Usuario.class.cast(request.getParameter("usuario"));
		Estabelecimento estabelecimento = Estabelecimento.class.cast("estabelecimento");
		ZonedDateTime data = ZonedDateTime.class.cast("data");
		comentarioDAO
				.inserirComentario(new Comentario(comentario, comentarioRespondido, usuario, estabelecimento, data));
		response.sendRedirect("tela-inicial");

	}

	/* ESTABELECIMENTO */
	private void mostrarFormularioCadastroEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-estabelecimento.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioEditarEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editar-perfil-estabelecimento");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaPesquisaEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/encontrar-estabelecimentos");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Estabelecimento estabelecimento = estabelecimentoDAO.recuperarEstabelecimentoId(2L);
		request.setAttribute("estabelecimento", estabelecimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-estabelecimento.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int idEndereco = Integer.parseInt(request.getParameter("id-endereco"));
		String logradouro = request.getParameter("logradouro");
		String tipoLogradouro = request.getParameter("tipo_logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		Endereco endereco = new Endereco(idEndereco, logradouro, tipoLogradouro, numero, complemento, bairro, cidade,
				estado);
		enderecoDAO.inserirEndereco(endereco);

		Long idEstabelecimento = Long.parseLong(request.getParameter("id-estabelecimento"));
		Categoria categoria = Categoria.class.cast(request.getParameter("categoria"));
		String nome = request.getParameter("nome");

		estabelecimentoDAO.atualizarEstabelecimento(new Estabelecimento(idEstabelecimento, categoria, nome, endereco));
		response.sendRedirect("tela-inicial");
	}

	private void deletarEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id-estabelecimento"));
		estabelecimentoDAO.deletarEstabelecimento(id);
		response.sendRedirect("tela-inicial");
	}

	private void inserirEstabelecimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String logradouro = request.getParameter("logradouro");
		String tipoLogradouro = request.getParameter("tipo_logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		Endereco endereco = new Endereco(logradouro, tipoLogradouro, numero, complemento, bairro, cidade, estado);
		enderecoDAO.inserirEndereco(endereco);

		Categoria categoria = categoriaDAO.recuperarCategoriaNome(request.getParameter("categoria"));
		String nome = request.getParameter("nome");
		estabelecimentoDAO.inserirEstabelecimento(new Estabelecimento(categoria, nome, endereco));
		response.sendRedirect("tela-inicial");
	}

	/* USUÁRIO */

	private void mostrarFormularioCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome-usuario");
		String nomeDeUsuario = request.getParameter("nome-de-usuario");
		String cpf = request.getParameter("cpf-usuario");
		String email = request.getParameter("email-usuario");
		String pronome = request.getParameter("pronome-usuario");
		LocalDate data = LocalDate.parse(request.getParameter("data-nascimento-usuario"));
		String senha = request.getParameter("senha-usuario");
		usuarioDAO.inserirUsuario(new Usuario(nome, pronome, nomeDeUsuario, email, cpf, senha, data));
		response.sendRedirect("tela-inicial");
	}

	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id-usuario"));
		String pronome = request.getParameter("pronome-usuario");
		String email = request.getParameter("email-usuario");
		String nomeDeUsuario = request.getParameter("nome-de-usuario");
		String senha = request.getParameter("senha-usuario");
		String nome = request.getParameter("nome-usuario");
		String cpf = request.getParameter("cpf-usuario");
		LocalDate data = LocalDate.parse(request.getParameter("data-nascimento-usuario"));
		usuarioDAO.atualizarUsuario(new Usuario(id, nome, pronome, nomeDeUsuario, email, cpf, senha, data));
		response.sendRedirect("");
	}

	private void mostrarPerfilUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		request.setAttribute("usuario", usuario);
		usuarioDAO.recuperarPontuacaoUsuario(2L);
		conquistaDAO.recuperarConquistasMaisRecentes(2L);
		comentarioDAO.recuperarComentariosOrdenadoMaisRecente(2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-usuario.jsp");
		dispatcher.forward(request, response);
		System.out.println("metodo perfil usuario chamado");
		System.out.println(usuario.getNome());

	}

	private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean existe = false;
		existe = usuarioDAO.verificarUsuario(email, senha);

		if (existe) {
			HttpSession sessao = request.getSession();
			Usuario usuario = usuarioDAO.recuperarUsuarioEmail(email);
			sessao.setAttribute("usuarioLogado", usuario);
			response.sendRedirect("perfil-usuario");
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("login-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormularioEditarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		request.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil-usuario.jsp");
		dispatcher.forward(request, response);

	}

	private void encerrarSessao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().invalidate();
		response.sendRedirect("perfil-usuario");
	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		usuarioDAO.deletarUsuario(usuario);
		response.sendRedirect("tela-inicial");
	}

	private void mostrarRanque(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ranque-usuario");
		dispatcher.forward(request, response);
	}
}

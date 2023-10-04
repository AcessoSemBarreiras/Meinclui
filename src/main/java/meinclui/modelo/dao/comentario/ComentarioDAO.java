package meinclui.modelo.dao.comentario;

import java.util.List;

import meinclui.modelo.entidade.comentario.Comentario;
import meinclui.modelo.entidade.estabelecimento.Estabelecimento;
import meinclui.modelo.entidade.usuario.Usuario;

public interface ComentarioDAO {

	void inserirComentario(Comentario comentario);

	void deletarComentario(int idComentario);

	void atualizarComentario(Comentario comentario);

	List<Comentario> recuperarComentarios();

	List<Comentario> recuperarComentariosPeloEstabelecimento(int idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaiorQuantidadeGostei(int idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaiorQuantidadeNaoGostei(int idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaisAntigo(int idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaisRecente(int idEstabelecimento);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaiorQuantidadeGostei(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaiorQuantidadeNaoGostei(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaisAntigo(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaisRecente(Long idUsuario);

}
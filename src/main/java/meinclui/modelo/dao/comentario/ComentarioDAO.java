package meinclui.modelo.dao.comentario;

import java.util.List;

import meinclui.modelo.entidade.comentario.Comentario;
import meinclui.modelo.entidade.estabelecimento.Estabelecimento;

public interface ComentarioDAO {

	void inserirComentario(Comentario comentario);

	void deletarComentario(int idComentario);

	void atualizarComentario(Comentario comentario);

	List<Comentario> recuperarComentarios();

	List<Comentario> recuperarComentariosPeloEstabelecimento(Long idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaiorQuantidadeGostei(Long idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaiorQuantidadeNaoGostei(Long idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaisAntigo(Long idEstabelecimento);

	List<Comentario> recuperarComentariosOrdenadoMaisRecente(Long idEstabelecimento);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaiorQuantidadeGostei(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaiorQuantidadeNaoGostei(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaisAntigo(Long idUsuario);

	List<Comentario> recuperarComentariosUsuarioOrdenadoMaisRecente(Long idUsuario);

	List<Comentario> recuperarComentariosRespostas(Estabelecimento estabelecimento);

	Comentario recuperarComentarioId(int id);
}

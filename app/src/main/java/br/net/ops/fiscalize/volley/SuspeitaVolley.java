package br.net.ops.fiscalize.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.net.ops.fiscalize.R;
import br.net.ops.fiscalize.utils.UtilVolley;
import br.net.ops.fiscalize.utils.Utilidade;
import br.net.ops.fiscalize.vo.Suspeita;

public class SuspeitaVolley {

	private static final String TAG = "SuspeitaVolley";

    private static final String URL = Utilidade.REST_SERVIDOR + "suspeita/adicionar";
	private static final int METHOD = Request.Method.POST;
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

	private static final String PARAM_TOKEN_ID = "tokenId";
	private static final String PARAM_NOTA_FISCAL_ID = "notaFiscalId";
    private static final String PARAM_SUSPEITA = "suspeita";
    private static final String PARAM_SUSPEITA_VALOR = "suspeitaValor";
    private static final String PARAM_SUSPEITA_OBJETO = "suspeitaObjeto";
    private static final String PARAM_SUSPEITA_BENEFICIARIO = "suspeitaBeneficiario";
    private static final String PARAM_COMENTARIOS = "comentarios";

    private Context context;
    private StringRequest request;
    private SuspeitaListener suspeitaListener;

    public interface SuspeitaListener {
        void onSuspeitaAdicionada(String mensagem);
        void onSuspeitaErro(String erro);
    }

    public SuspeitaVolley(final Context context, final Suspeita suspeita, final SuspeitaListener suspeitaListener) {

        this.context = context;
        this.suspeitaListener = suspeitaListener;
        this.request = new StringRequest(METHOD, URL, listenerSucesso, listenerErro) {
            @Override
            protected Map<String,String> getParams(){
                String tokenId = "";
                if(suspeita.getUsuario()!=null && suspeita.getUsuario().getTokenId()!=null) {
                    tokenId = String.valueOf(suspeita.getUsuario().getTokenId());
                }

                String notaFiscalId = "";
                if(suspeita.getNotaFiscal()!=null && suspeita.getNotaFiscal().getNotaFiscalId()!=null) {
                    notaFiscalId = String.valueOf(suspeita.getNotaFiscal().getNotaFiscalId());
                }

                boolean isSuspeita = false;
                if(suspeita.getSuspeita()!=null) {
                    isSuspeita = suspeita.getSuspeita();
                }

                boolean notaSuspeitaValor = false;
                if(suspeita.getSuspeitaValor()!=null) {
                    notaSuspeitaValor = suspeita.getSuspeitaValor();
                }

                boolean notaSuspeitaObjeto = false;
                if(suspeita.getSuspeitaObjeto()!=null) {
                    notaSuspeitaObjeto = suspeita.getSuspeitaObjeto();
                }

                boolean notaSuspeitaFornecedor = false;
                if(suspeita.getSuspeitaBeneficiario()!=null) {
                    notaSuspeitaFornecedor = suspeita.getSuspeitaBeneficiario();
                }

                String comentarios = "";
                if(suspeita.getComentarios()!=null) {
                    comentarios = suspeita.getComentarios();
                }

                Map<String, String> params = new HashMap<>();
                params.put(PARAM_TOKEN_ID, String.valueOf(tokenId));
                params.put(PARAM_NOTA_FISCAL_ID, String.valueOf(notaFiscalId));
                params.put(PARAM_SUSPEITA, String.valueOf(isSuspeita));
                params.put(PARAM_SUSPEITA_VALOR, String.valueOf(notaSuspeitaValor));
                params.put(PARAM_SUSPEITA_OBJETO, String.valueOf(notaSuspeitaObjeto));
                params.put(PARAM_SUSPEITA_BENEFICIARIO, String.valueOf(notaSuspeitaFornecedor));
                params.put(PARAM_COMENTARIOS, comentarios);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Content-Type", CONTENT_TYPE);
                return params;
            }
        };

    }

	private Response.Listener<String> listenerSucesso = new Response.Listener<String>() {
		@Override
		public void onResponse(String response) {
			try {
				// Extrai tokenId
				JSONObject json = new JSONObject(response);
				String mensagem = json.getString(Utilidade.REST_JSON_MENSAGEM);

                suspeitaListener.onSuspeitaAdicionada(mensagem);
			} catch(JSONException e) {
				try {
					// Procura Erro no retorno
					JSONObject json = new JSONObject(response);
					String erro = json.getString(Utilidade.REST_JSON_ERRO);
                    suspeitaListener.onSuspeitaErro(erro);
				} catch(JSONException ex) {
					// Resposta inválida
                    suspeitaListener.onSuspeitaErro(context.getString(R.string.exception_rest));
				}
			}
		}
	};

    private Response.ErrorListener listenerErro = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            UtilVolley.logarErro(error);
            suspeitaListener.onSuspeitaErro(context.getString(R.string.exception_comunicacao));
        }
    };

    public StringRequest getRequest() {
        return request;
    }

}
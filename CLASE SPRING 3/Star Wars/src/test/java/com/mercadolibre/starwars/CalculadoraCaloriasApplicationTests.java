package com.mercadolibre.calculadora_calorias;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadora_calorias.model.IngredienteDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraCaloriasApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	private String platoConIngredientesJsonString;

	@BeforeEach
	public void init() {
		ObjectMapper objectMapper = new ObjectMapper();

		IngredienteDTO jamonCrudo = new IngredienteDTO("Jamón cocido", 100.0);
		IngredienteDTO aceitunasNegras = new IngredienteDTO("Aceitunas negras", 50.0);

		PlatoDTO picada = new PlatoDTO("picada");
		List<IngredienteDTO> ingredientes = new ArrayList<>();
		ingredientes.add(jamonCrudo);
		ingredientes.add(aceitunasNegras);
		picada.setIngredientes(ingredientes);

		try {
			platoConIngredientesJsonString = objectMapper.writeValueAsString(picada);
			objectMapper.writeValue(new File("src/main/resources/data/platoPrueba.json"), picada);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void platoDevuelveCaloriasTotalesTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/comida/calorias_totales")
				.contentType(MediaType.APPLICATION_JSON)
				.content(platoConIngredientesJsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\"nombrePlato\":\"picada\",\"caloriasTotales\":475.0}"));
	}

	@Test
	void platoDevuelveCaloriasPorIngredienteTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/comida/calorias_por_ingrediente")
				.contentType(MediaType.APPLICATION_JSON)
				.content(platoConIngredientesJsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"name\":\"Jamón cocido\",\"calories\":126.0},{\"name\":\"Aceitunas negras\",\"calories\":349.0}]"));
	}

	@Test
	void platoDevuelveIngredienteConMasCaloriasTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/comida/ingrediente_con_mas_calorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content(platoConIngredientesJsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\"name\":\"Aceitunas negras\",\"calories\":349.0}"));
	}
}

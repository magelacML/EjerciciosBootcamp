package com.mercadolibre.calculadora_calorias;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadora_calorias.model.request.AsignaturaDTO;
import com.mercadolibre.calculadora_calorias.model.request.AlumnoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GenerarDiplomaApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	private String platoConIngredientesJsonString;


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

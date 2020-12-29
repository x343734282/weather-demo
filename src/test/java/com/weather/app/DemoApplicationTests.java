package com.weather.app;

import com.weather.app.module.WeatherResponseView;
import com.weather.app.service.IWeatherAdapterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class DemoApplicationTests {

    @MockBean
    private IWeatherAdapterService weatherApi;

    @Autowired
    private MockMvc mvc;

    @Test
    void weatherApiTest() {

        try {
            Mockito.when(this.weatherApi.getWeatherByCityName("dalian")).thenReturn(new WeatherResponseView("dalian", "", "", "", ""));

            this.mvc.perform(get("/api/v1/realtime/weather").queryParam("city", "dalian")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("dalian")));
        } catch (Exception e) {
        }

    }

    @Test
    void weatherApiErrorCaseTest() {

        try {
            Mockito.when(this.weatherApi.getWeatherByCityName("dalian")).thenThrow(new Exception());

            this.mvc.perform(get("/api/v1/realtime/weather")
                    .queryParam("city", "dalian"))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
        }

    }

}

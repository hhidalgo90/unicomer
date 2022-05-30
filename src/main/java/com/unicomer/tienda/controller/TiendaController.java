package com.unicomer.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.unicomer.tienda.model.ProspectoUnicomer;
import com.unicomer.tienda.service.TiendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = "tienda-unicomer-api")
@RestController
@RequestMapping(path = "/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @Autowired
    private ObjectMapper objectMapper;

    @ApiOperation(nickname = "registrar", value ="Registra un nuevo cliente en base de datos.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody ProspectoUnicomer request){
        return tiendaService.registrar(request);
    }

    @ApiOperation(nickname = "get", value ="Obtiene un cliente segun su ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @GetMapping(path = "/{id}")
    public ProspectoUnicomer get(@PathVariable("id") Long id){
        return tiendaService.getById(id);
    }

    @ApiOperation(nickname = "delete", value ="Elimina el registro de un cliente segun su ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return tiendaService.delete(id);
    }

    @ApiOperation(nickname = "getAll", value ="Obtiene todos los clientes registrados.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping()
    public List<ProspectoUnicomer> getAll(){
        return tiendaService.getAll();
    }

    @ApiOperation(nickname = "updateCustomer", value ="Actualiza datos de un cliente parcial o totalmente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PatchMapping(path = "/{id}")
    public ResponseEntity<ProspectoUnicomer> updateCustomer(@PathVariable Long id, @RequestBody JsonPatch patch) {
        try {
            ProspectoUnicomer prospecto = tiendaService.getById(id);
            if (prospecto != null) {
            	ProspectoUnicomer prospectoActualizado = obtenerProspectoActualizado(patch, prospecto);
                return tiendaService.registrar(prospectoActualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ProspectoUnicomer obtenerProspectoActualizado(JsonPatch patch, ProspectoUnicomer prospecto) throws JsonProcessingException, JsonPatchException {
    	JsonNode json = objectMapper.convertValue(prospecto, JsonNode.class);
    	JsonNode patched = patch.apply(json);
        return objectMapper.treeToValue(patched, ProspectoUnicomer.class);
    }
}

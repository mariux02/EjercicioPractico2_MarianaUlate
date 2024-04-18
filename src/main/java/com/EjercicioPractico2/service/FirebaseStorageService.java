package com.EjercicioPractico2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "hoteleriamarianaulate.appspot.com";

    //Esta es la ruta bÃ¡sica de este proyecto 
    final String rutaSuperiorStorage = "hoteleriaMarianaUlate";

    //UbicaciÃ³n donde se encuentra el archivo de configuraciÃ³n Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "hoteleriamarianaulate-firebase-adminsdk-p6hc6-5e20f6b800";
}
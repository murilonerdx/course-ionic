package com.murilo.cursomc.service;


import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.*;
import com.dropbox.core.v2.sharing.SharedLinkErrorException;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.murilo.cursomc.exceptions.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

@Service
public class DropboxService {

    private Logger LOG = LoggerFactory.getLogger(DropboxService.class);

    @Autowired
    private DbxClientV2 dbxClient;


    //



    public URI uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            return uploadFile(inputStream, fileName);
        } catch (IOException e) {
            throw new FileException("Erro de IO: " + e.getMessage());
        }

    }

    public URI uploadFile(InputStream is, String fileName) {
        try {
            LOG.info("Iniciando upload");
            FileMetadata metadata = dbxClient.files().uploadBuilder("/" + fileName).uploadAndFinish(is);
            LOG.info("Upload feito");
            String url = dbxClient.sharing().createSharedLinkWithSettings(metadata.getId()).getUrl();



            // cors configuration
            String newUrl = "https://dl.dropboxusercontent.com" + url.substring(23);

            LOG.info("URL gerada");
            return new URI(newUrl);
        } catch (IOException e) {
            throw new FileException("Erro de IO: " + e.getMessage());
        } catch (DbxException e) {
            throw new FileException("Erro de Dbx: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new FileException("Erro de URISyntax: " + e.getMessage());
        }
    }

    public URI getUriFromFile(String fileName) {
        try {
            ListFolderResult result = dbxClient.files().listFolder("");

            for (Metadata metadata : result.getEntries()) {
                if (metadata.getName().equalsIgnoreCase(fileName)) {

                    String url = null;

                    List<SharedLinkMetadata> list = dbxClient.sharing().listSharedLinksBuilder()
                            .withPath(((FileMetadata) metadata).getId()).start().getLinks();
                    for (SharedLinkMetadata shared : list) {
                        url = shared.getUrl();
                    }

                    if (url == null) {
                        url = dbxClient.sharing().createSharedLinkWithSettings(((FileMetadata) metadata).getId())
                                .getUrl();
                        LOG.info("URL gerada");
                    }

                    // cors configuration
                    String newUrl = "https://dl.dropboxusercontent.com" + url.substring(23);

                    return new URI(newUrl);
                }
            }
            return null;
        } catch (ListFolderErrorException e) {
            throw new FileException("Erro de ListFolderError: " + e.getMessage());
        } catch (DbxException e) {
            throw new FileException("Erro de Dbx: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new FileException("Erro de URISyntax: " + e.getMessage());
        }
    }

    public void deleteFile(String url) {
        try {
            //changing to standard dropbox url
            url = "https://www.dropbox.com" + url.substring(33);

            SharedLinkMetadata metadata = dbxClient.sharing().getSharedLinkMetadata(url);

            if(!metadata.getName().equalsIgnoreCase("blank-avatar.jpg")
                    && !metadata.getName().equalsIgnoreCase("cat.jpg")
                    && !metadata.getName().equalsIgnoreCase("prod.jpg")) {

                dbxClient.files().deleteV2(metadata.getId());
                LOG.info("Imagem deletada");
            }
            else {
                LOG.info("Imagem não deletada");
            }
        }
        catch(SharedLinkErrorException e) {
            throw new FileException("Erro de SharedLinkError: " + e.getMessage());
        }
        catch(DbxException e) {
            throw new FileException("Erro de Dbx: " + e.getMessage());
        }

    }
}

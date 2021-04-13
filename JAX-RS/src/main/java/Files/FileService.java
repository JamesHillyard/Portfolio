package Files;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/file")
public class FileService {

    private static final String TXT_FILE_PATH = "/home/james/Documents/SampleFile.txt";
    private static final String IMG_FILE_PATH = "/home/james/Documents/banana.jpg";

    @GET
    @Path("txt")
    @Produces("text/plain")
    public Response getTxtFile() {
        File file = new File(TXT_FILE_PATH);
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition","attachment; filename=\"Sample Information\"");
        return response.build();
    }

    @GET
    @Path("img")
    @Produces("image/jpeg")
    public Response getPngFile() {
        File file = new File(IMG_FILE_PATH);
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition","attachment; filename=\"Banana\"");
        return response.build();
    }

}

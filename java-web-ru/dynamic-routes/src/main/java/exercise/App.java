package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() throws NotFoundResponse {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            String id = ctx.pathParamAsClass("id", String.class).get();

            List<Map<String, String>> company = COMPANIES.stream()
                    .filter(map -> map.containsValue(id))
                    .collect(Collectors.toList());

            if (company.size() == 0) {
                throw new NotFoundResponse("Company not found");
            }

            int indexOfCompanyInList = 0;
            for (int i = 0; i < COMPANIES.size(); i++) {
                if (COMPANIES.get(i).get("id").equals(id)) {
                    indexOfCompanyInList = i;
                }
            }
            ctx.json(COMPANIES.get(indexOfCompanyInList));
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

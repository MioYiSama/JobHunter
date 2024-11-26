package top.mioyi.utils;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

public class OpenAPIUtils {
    public static final License LICENSE = new License()
            .name("GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
            .url("https://www.gnu.org/licenses/agpl-3.0.md")
            .identifier("AGPL-3.0");

    public static final Contact CONTACT = new Contact()
            .name("MioYiSama")
            .email("mioyisama@gmail.com")
            .url("https://www.mioyi.top");

    public static final String VERSION = "1.0.0";

    public static final String DESCRIPTION = "API文档";
}

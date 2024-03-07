package hexlet.code;
import hexlet.code.schemas.StringSchema;

public interface StringOperations {
    StringSchema minLength(int minLength);
    StringSchema contains(String contains);
}

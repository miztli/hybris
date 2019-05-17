package concerttours.constraints;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
 
@Target(
{ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = NotLoremIpsumValidator.class)
@Documented
public @interface NotLoremIpsum
{
    String message() default "{concerttours.constraints.NotLoremIpsum.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

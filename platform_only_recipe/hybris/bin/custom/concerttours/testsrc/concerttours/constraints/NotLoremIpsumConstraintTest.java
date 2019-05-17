package concerttours.constraints;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.validation.exceptions.HybrisConstraintViolation;
import de.hybris.platform.validation.services.ValidationService;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import concerttours.model.BandModel;
import concerttours.model.NotLoremIpsumConstraintModel;

@IntegrationTest
public class NotLoremIpsumConstraintTest extends ServicelayerTransactionalTest
{
   @Resource
   private ModelService modelService;
   @Resource
   private ValidationService validationService;
   @Before
   public void setup() throws Exception
   {
       createCoreData();
       importCsv("/impex/essentialdata-constraints.impex", "UTF-8");
       validationService.reloadValidationEngine();
   }
   @Test
   public void testLoremIpsumConstraint()
   {
       final BandModel band = modelService.create(BandModel.class);
       band.setCode("LoremIpsumTest1");
       band.setName("LoremIpsumBand");
       band.setHistory("Lorem Ipsum is here");
       final Set<HybrisConstraintViolation> violations = validationService.validate(band);
       Assert.assertTrue("The violation set sould not be null or empty", violations != null && violations.size() > 0);
       Assert.assertEquals("There should be one constraint violations", 1, violations.size());
       for (final HybrisConstraintViolation hybrisConstraintViolation : violations)
       {
           Assert.assertEquals(NotLoremIpsumConstraintModel.class, hybrisConstraintViolation.getConstraintModel().getClass());
       }
   }
}

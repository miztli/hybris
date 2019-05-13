package de.hybris.platform.servicelayer.interceptor;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.enums.SavedValueEntryType;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.hmc.model.SavedValueEntryModel;
import de.hybris.platform.hmc.model.SavedValuesModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

@IntegrationTest
public class PartOfModelRegisterForRemoveInterceptorIntegrationTest extends ServicelayerTransactionalBaseTest {

    @Resource
    ModelService modelService;

    @Resource
    UserService userService;

    @Resource
    TypeService typeService;

    @Test
    public void testRemovalOfNonWritablePartOfAttribute()
    {
        //given
        SavedValuesModel savedValues = modelService.create(SavedValuesModel.class);
        SavedValueEntryModel savedValueEntry = modelService.create(SavedValueEntryModel.class);

        savedValues.setTimestamp(new Date());
        savedValues.setModifiedItemDisplayString("Product[PK1213242]");
        savedValues.setModifiedItemType(typeService.getComposedTypeForClass(ProductModel.class));
        savedValues.setModificationType(SavedValueEntryType.CHANGED);
        savedValues.setUser(userService.getCurrentUser());

        savedValueEntry.setParent(savedValues);
        savedValueEntry.setModifiedAttribute(ProductModel.DESCRIPTION);
        savedValueEntry.setOldValueAttributeDescriptor(typeService.getComposedTypeForClass(ProductModel.class).getCatalogVersionAttribute());

        modelService.saveAll(savedValues, savedValueEntry);

        //when
        modelService.remove(savedValues);

        //then
        assertThat(modelService.isRemoved(savedValues)) .isTrue();
        assertThat(modelService.isRemoved(savedValueEntry)) .isTrue();
    }
}

package io.github.foundationgames.automobility.entity;

import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.render.ExhaustFumesModel;
import io.github.foundationgames.automobility.automobile.render.SkidEffectModel;
import io.github.foundationgames.automobility.automobile.render.engine.IronEngineModel;
import io.github.foundationgames.automobility.automobile.render.frame.StandardFrameModel;
import io.github.foundationgames.automobility.automobile.render.wheel.StandardWheelModel;
import io.github.foundationgames.automobility.entity.render.AutomobileEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public enum AutomobilityEntities {;
    public static final EntityType<AutomobileEntity> AUTOMOBILE = Registry.register(
            Registry.ENTITY_TYPE,
            Automobility.id("automobile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, AutomobileEntity::new).dimensions(new EntityDimensions(1f, 0.66f, true)).trackRangeBlocks(50).trackedUpdateRate(10).build()
    );

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        EntityRendererRegistry.INSTANCE.register(AUTOMOBILE, AutomobileEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(StandardFrameModel.MODEL_LAYER, StandardFrameModel::createModelData);

        EntityModelLayerRegistry.registerModelLayer(StandardWheelModel.MODEL_LAYER, StandardWheelModel::createModelData);

        EntityModelLayerRegistry.registerModelLayer(IronEngineModel.MODEL_LAYER, IronEngineModel::createModelData);

        EntityModelLayerRegistry.registerModelLayer(SkidEffectModel.MODEL_LAYER, SkidEffectModel::createModelData);
        EntityModelLayerRegistry.registerModelLayer(ExhaustFumesModel.MODEL_LAYER, ExhaustFumesModel::createModelData);
    }
}
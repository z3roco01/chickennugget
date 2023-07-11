package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.block.CuttingBoard;
import z3roco01.chickennugget.block.MortarAndPestle;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class Blocks {
    public static final CuttingBoard    CUTTING_BOARD     = new CuttingBoard();
    public static final MortarAndPestle MORTAR_AND_PESTLE = new MortarAndPestle();
    public static final Block SALT_BLOCK = new Block(FabricBlockSettings.create());

    public static void register() {
        Registry.register(Registries.BLOCK, mkId("cutting_board"), CUTTING_BOARD);
        Registry.register(Registries.BLOCK, mkId("mortar_and_pestle"), MORTAR_AND_PESTLE);
        Registry.register(Registries.BLOCK, mkId("salt_block"), SALT_BLOCK);
    }
}

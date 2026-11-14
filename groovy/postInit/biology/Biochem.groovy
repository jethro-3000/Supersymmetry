import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

// Estrogen

MIXER.recipeBuilder()
        .fluidInputs(fluid('gtfo_soybean_oil') * 10020)
        .fluidInputs(fluid('phosphoric_acid') * 10)
        .fluidOutputs(fluid('acid_conditioned_soybean_oil') * 10030)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('acid_conditioned_soybean_oil') * 10020)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 10)
        .fluidOutputs(fluid('neutralized_soybean_oil') * 10000)
        .fluidOutputs(fluid('soapstock') * 110)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('neutralized_soybean_oil') * 10000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('washed_neutralized_soybean_oil') * 10000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .inputs(ore('dustClay'))
    .fluidInputs(fluid('washed_neutralized_soybean_oil') * 10000)
    .outputs(metaitem('dustSpentClay'))
    .fluidOutputs(fluid('clean_neutralized_soybean_oil') * 10000)
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('clean_neutralized_soybean_oil') * 10000)
    .fluidInputs(fluid('dense_steam') * 1000)
    .fluidOutputs(fluid('seed_oil') * 9950)
    .fluidOutputs(fluid('deoderizer_distillate') * 50)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('deoderizer_distillate') * 50)
    .fluidInputs(fluid('water') * 600)
    .fluidInputs(fluid('methanol') * 4700)
    .fluidInputs(fluid('potassium_hydroxide') * 150)
    .fluidOutputs(fluid('saponified_deoderizer_distillate') * 5500)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('saponified_deoderizer_distillate') * 5500)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('phytosterol_crystal_slurry') * 6500)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .notConsumable(metaitem('fluid_filter'))
    .fluidInputs(fluid('phytosterol_crystal_slurry') * 6550)
    .fluidInputs(fluid('methanol') * 600)
    .fluidInputs(fluid('isohexane') * 100)
    .fluidOutputs(fluid('mixed_phytosterols') * 20)
    .fluidOutputs(fluid('wastewater') * 7180)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()
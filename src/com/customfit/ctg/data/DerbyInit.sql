CREATE TABLE Recipe
(
	Name VARCHAR(255),
	Description VARCHAR(1000),
	Instructions VARCHAR(3000),
	ServingSizeQuantity DECIMAL,
	ServingSizeUnit VARCHAR(25),
	Servings DECIMAL,
	Rating DECIMAL
)

CREATE TABLE GroceryCategory
(
	Name VARCHAR(255)
)

CREATE TABLE Ingredient
(
	Name VARCHAR(255),
	GroceryCategoryName VARCHAR(255)
)

CREATE TABLE Recipe_Ingredient
(
	IngredientName VARCHAR(350),
	MeasurementQuantity DECIMAL,
	MeasurementUnit VARCHAR(25)
)

CREATE TABLE Recipe_NutritionalInformation
(
	RecipeName VARCHAR(350),
	Calories DECIMAL,
	TotalFatInGrams DECIMAL,
	SaturatedFatInGrams DECIMAL,
	TransFatInGrams DECIMAL,
	CholesterolInMilligrams DECIMAL,
	SodiumInMilligrams DECIMAL,
	TotalCarbohydrateInGrams DECIMAL,
	DietaryFiberInGrams DECIMAL,
	SugarsInGrams DECIMAL,
	ProteinInGrams DECIMAL
)

CREATE TABLE UserProfile
(
	UserName VARCHAR(255),
	MinGoals_Calories DECIMAL,
	MinGoals_TotalFatInGrams DECIMAL,
	MinGoals_SaturatedFatInGrams DECIMAL,
	MinGoals_TransFatInGrams DECIMAL,
	MinGoals_CholesterolInMilligrams DECIMAL,
	MinGoals_SodiumInMilligrams DECIMAL,
	MinGoals_TotalCarbohydrateInGrams DECIMAL,
	MinGoals_DietaryFiberInGrams DECIMAL,
	MinGoals_SugarsInGrams DECIMAL,
	MinGoals_ProteinInGrams DECIMAL,	
	MaxGoals_Calories DECIMAL,
	MaxGoals_TotalFatInGrams DECIMAL,
	MaxGoals_SaturatedFatInGrams DECIMAL,
	MaxGoals_TransFatInGrams DECIMAL,
	MaxGoals_CholesterolInMilligrams DECIMAL,
	MaxGoals_SodiumInMilligrams DECIMAL,
	MaxGoals_TotalCarbohydrateInGrams DECIMAL,
	MaxGoals_DietaryFiberInGrams DECIMAL,
	MaxGoals_SugarsInGrams DECIMAL,
	MaxGoals_ProteinInGrams DECIMAL	
)
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/feature1.feature");
formatter.feature({
  "name": "Product details testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validation of each products name and price",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch challenge app",
  "keyword": "Given "
});
formatter.match({
  "location": "glue.StepDefinitionsClass.launchApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify products name and price of each product",
  "keyword": "Then "
});
formatter.match({
  "location": "glue.StepDefinitionsClass.productDetailsValidation()"
});
formatter.write("Product name test passed for product");
formatter.write("Product price test passed for product");
formatter.write("Product name test passed for Practical Remove");
formatter.write("Product price test passed for Practical Remove");
formatter.write("Product name test passed for Perfect Daughter");
formatter.write("Product price test passed for Perfect Daughter");
formatter.write("Product name test passed for Unused Imagination");
formatter.write("Product price test passed for Unused Imagination");
formatter.write("Product name test passed for Utter Rise");
formatter.write("Product price test passed for Utter Rise");
formatter.write("Product name test passed for Slushy Welcome");
formatter.write("Product price test passed for Slushy Welcome");
formatter.write("Product name test passed for Quizzical Solution");
formatter.write("Product price test passed for Quizzical Solution");
formatter.write("Product name test passed for Snarling Obligation");
formatter.write("Product price test passed for Snarling Obligation");
formatter.write("Product name test passed for Noisy Shame");
formatter.write("Product price test passed for Noisy Shame");
formatter.write("Product name test passed for Dizzy Box");
formatter.write("Product price test passed for Dizzy Box");
formatter.write("Product name test passed for Polished Hire");
formatter.write("Product price test passed for Polished Hire");
formatter.write("Product name test passed for Burdensome Chance");
formatter.write("Product price test passed for Burdensome Chance");
formatter.write("Product name test passed for Aged Game");
formatter.write("Product price test passed for Aged Game");
formatter.write("Product name test passed for Favorable Opposite");
formatter.write("Product price test passed for Favorable Opposite");
formatter.write("Product name test passed for Ecstatic Film");
formatter.write("Product price test passed for Ecstatic Film");
formatter.write("Product name test passed for Necessary Transition");
formatter.write("Product price test passed for Necessary Transition");
formatter.write("Product name test passed for Naughty Chart");
formatter.write("Product price test passed for Naughty Chart");
formatter.write("Product name test passed for Anxious Lady");
formatter.write("Product price test passed for Anxious Lady");
formatter.write("Product name test passed for Musty Bridge");
formatter.write("Product price test passed for Musty Bridge");
formatter.write("Product name test passed for Hurtful Pound");
formatter.write("Product price test passed for Hurtful Pound");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close app",
  "keyword": "When "
});
formatter.match({
  "location": "glue.StepDefinitionsClass.closeApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
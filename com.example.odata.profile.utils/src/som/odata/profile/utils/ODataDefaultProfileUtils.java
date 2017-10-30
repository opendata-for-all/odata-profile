package som.odata.profile.utils;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ODataDefaultProfileUtils {

	public static void applyODServiceStereotype(Package pkg) {
		Stereotype odService = pkg.getApplicableStereotype("ODataProfile::ODService");
		if (!pkg.isStereotypeApplied(odService)) {
			pkg.applyStereotype(odService);
			UMLUtil.setTaggedValue(pkg, odService, "version", "4.0");
			UMLUtil.setTaggedValue(pkg, odService, "entityContainerName", pkg.getName() + "Service");
			UMLUtil.setTaggedValue(pkg, odService, "schemaNamespace", "com.exmple." + pkg.getName());
			UMLUtil.setTaggedValue(pkg, odService, "schemaAlias", pkg.getName());
		}

	}

	public static void applyODEntityType(org.eclipse.uml2.uml.Class clazz) {
		Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntityType");
		if (!clazz.isStereotypeApplied(stereotype)) {
			clazz.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(clazz, stereotype, "name", clazz.getName());
			if (clazz.isAbstract()) {
				UMLUtil.setTaggedValue(clazz, stereotype, "abstract", true);
			}

		}
	}
	public static void applyODComplexType(DataType dataType) {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODComplexType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(dataType, stereotype, "name", dataType.getName());
			if (dataType.isAbstract()) {
				UMLUtil.setTaggedValue(dataType, stereotype, "abstract", true);
			}

		}
	}
	public static void applyODEnumType(DataType dataType) {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODEnumType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(dataType, stereotype, "name", dataType.getName());
		}
	}
	public static void applyODPrimitiveType(DataType dataType) {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODPrimitiveType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
		
		}
	}


	public static void applyODEntitySet(org.eclipse.uml2.uml.Class clazz) {
		Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntitySet");
		if (!clazz.isStereotypeApplied(stereotype)) {
			clazz.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(clazz, stereotype, "name", getPlural(clazz.getName()));

		}
	}

	

	public static void applyODProperty(Property property) {
		if (property.getAssociation() == null && !property.isID()) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODProperty");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				if (property.getLower() == 1)
					UMLUtil.setTaggedValue(property, stereotype, "nullable", false);
				else 
					UMLUtil.setTaggedValue(property, stereotype, "nullable", true);
				if (property.getDefault() != null)
					UMLUtil.setTaggedValue(property, stereotype, "defaultValue", property.getDefault());
			}
		}
	}

	public static void applyODKey(Property property) {
		if(property.getAssociation() == null && property.isID()){
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODKey");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				
	
	}
}
	}
	
	public static void applyODataNavigationProperty(Property property) {
		if (property.getAssociation() != null) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODNavigationProperty");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				if (property.getLower() == 1)
					UMLUtil.setTaggedValue(property, stereotype, "nullable", false);
				else
					UMLUtil.setTaggedValue(property, stereotype, "nullable", true);
				if(property.getAggregation().equals(AggregationKind.COMPOSITE_LITERAL))
					UMLUtil.setTaggedValue(property, stereotype, "containsTarget", true);
				
			}
		}
	}
	
	public static void applyODataNavigationPropertyBinding(Property property) {
		if (property.getAssociation() != null) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODNavigationPropertyBinding");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "path", property.getName());
			}
		}
	}
	
	
	public static void resolveBaseType(org.eclipse.uml2.uml.Class clazz) {

		if (!clazz.getGeneralizations().isEmpty()) {
			Generalization generalization = clazz.getGeneralizations().get(0);
			Classifier general = generalization.getGeneral();
			if (general instanceof org.eclipse.uml2.uml.Class) {
				Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntityType");
				if (((org.eclipse.uml2.uml.Class) general).isStereotypeApplied(stereotype)) {
					Stereotype base = ((org.eclipse.uml2.uml.Class) general)
							.getAppliedStereotype("ODataProfile::ODEntityType");
					UMLUtil.setTaggedValue(clazz, stereotype, "basetype",
							((org.eclipse.uml2.uml.Class) general).getStereotypeApplication(base));

				}
			}

		}
	}
		public static String getPlural(String word){
			if(word.endsWith("y")){
				return word.substring(0, word.length()- 1)+"ies";
				
			}
			else
				return word+"s";
		}
}


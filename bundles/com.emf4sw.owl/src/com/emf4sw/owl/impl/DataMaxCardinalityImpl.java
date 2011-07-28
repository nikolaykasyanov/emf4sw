/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emf4sw.owl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.emf4sw.owl.DataMaxCardinality;
import com.emf4sw.owl.DataProperty;
import com.emf4sw.owl.DataRange;
import com.emf4sw.owl.OWLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Max Cardinality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emf4sw.owl.impl.DataMaxCardinalityImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link com.emf4sw.owl.impl.DataMaxCardinalityImpl#getDataRange <em>Data Range</em>}</li>
 *   <li>{@link com.emf4sw.owl.impl.DataMaxCardinalityImpl#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMaxCardinalityImpl extends DataPropertyRestrictionImpl implements DataMaxCardinality {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMaxCardinalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OWLPackage.Literals.DATA_MAX_CARDINALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCardinality() {
		return (Integer)eGet(OWLPackage.Literals.DATA_MAX_CARDINALITY__CARDINALITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinality(int newCardinality) {
		eSet(OWLPackage.Literals.DATA_MAX_CARDINALITY__CARDINALITY, newCardinality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRange getDataRange() {
		return (DataRange)eGet(OWLPackage.Literals.DATA_MAX_CARDINALITY__DATA_RANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataRange(DataRange newDataRange) {
		eSet(OWLPackage.Literals.DATA_MAX_CARDINALITY__DATA_RANGE, newDataRange);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProperty getProperty() {
		return (DataProperty)eGet(OWLPackage.Literals.DATA_MAX_CARDINALITY__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(DataProperty newProperty) {
		eSet(OWLPackage.Literals.DATA_MAX_CARDINALITY__PROPERTY, newProperty);
	}

} //DataMaxCardinalityImpl

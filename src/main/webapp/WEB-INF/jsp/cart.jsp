<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<section class="container" ng-app="cartApp">
	<div ng-controller="cartController" ng-init="initCartId('${cartId}')">
		<div>
			<a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
				class="glyphicon glyphicon-remove-sign"></span> Clear Cart
			</a> <a href="#" class="btn btn-success pull-right"> <span
				class="glyphicon-shopping-cart glyphicon"></span> Check out
			</a>
		</div>
		<table class="table table-hover">
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Unit price</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<tr ng-repeat="item in cart.cartItems">
				<td>{{item.product.productId}}-{{item.product.name}}</td>
				<td>{{item.quantity}}</td>
				<td>{{item.product.unitPrice}}</td>
				<td>{{item.totalPrice}}</td>
				<td><a href="#" class="label label-danger"
					ng-click="removeFromCart(item.product.productId)"> <span
						class="glyphicon glyphicon-remove" /></span> Remove
				</a></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th>Grand Total</th>
				<th>{{cart.grandTotal}}</th>
				<th></th>
			</tr>

		</table>
		<a href="<spring:url value="/products" />" class="btn btn-success">
			<span class="glyphicon-circle-arrow-left glyphicon"></span> continue
			shopping
		</a>
	</div>
</section>
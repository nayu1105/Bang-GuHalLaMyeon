<template>
  <section class="coupon-area pt-100 pb-30">
   <div class="container">
   <div class="row">
      <div class="col-md-6">
         <div class="coupon-accordion">
               <!-- ACCORDION START -->
               <h3>Returning customer? <span @click="handleShow" id="showlogin">Click here to login</span></h3>
               <div id="checkout-login" :class="`${showCouponContent ? 'show-content' : 'coupon-content'}`">
                  <div class="coupon-info">
                     <p class="coupon-text">Quisque gravida turpis sit amet nulla posuere lacinia. Cras sed est
                           sit amet ipsum luctus.</p>
                     <form action="#">
                           <p class="form-row-first">
                              <label>Username or email <span class="required">*</span></label>
                              <input type="text" />
                           </p>
                           <p class="form-row-last">
                              <label>Password <span class="required">*</span></label>
                              <input type="text" />
                           </p>
                           <p class="form-row">
                              <button class="e-btn e-btn-border" type="submit">Login</button>
                              <label>
                                 <input type="checkbox" />
                                 Remember me
                              </label>
                           </p>
                           <p class="lost-password">
                              <a href="#">Lost your password?</a>
                           </p>
                     </form>
                  </div>
               </div>
               <!-- ACCORDION END -->
         </div>
      </div>
      <div class="col-md-6">
         <div class="coupon-accordion">
               <!-- ACCORDION START -->
               <h3>Have a coupon? <span @click="showCheckoutContent" id="showcoupon">Click here to enter your code</span></h3>
               <div id="checkout_coupon" :class="`${showCheckout ? 'show-checkout' 
               :'coupon-checkout-content'}`">
                  <div class="coupon-info">
                     <form action="#">
                           <p class="checkout-coupon">
                              <input type="text" placeholder="Coupon Code" />
                              <button class="e-btn e-btn-border" type="submit">Apply Coupon</button>
                           </p>
                     </form>
                  </div>
               </div>
               <!-- ACCORDION END -->
         </div>
      </div>
   </div>
</div>
</section>
</template>

<script>
export default {
   name:'CouponArea',
   data () {
      return {
         showCouponContent:false,
         showCheckout:false,
      }
   },
   methods:{
      handleShow () {
         return this.showCouponContent = !this.showCouponContent
      },
      showCheckoutContent () {
         return this.showCheckout = !this.showCheckout
      }
   }
};
</script>


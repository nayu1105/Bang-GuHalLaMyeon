<template>
  <section class="signup__area po-rel-z1 pt-100 pb-145">
    <div class="sign__shape">
      <img class="man-1" src="../../assets/img/icon/sign/man-3.png" alt="" />
      <img class="man-2 man-22" src="../../assets/img/icon/sign/man-2.png" alt="" />
      <img class="circle" src="../../assets/img/icon/sign/circle.png" alt="" />
      <img class="zigzag" src="../../assets/img/icon/sign/zigzag.png" alt="" />
      <img class="dot" src="../../assets/img/icon/sign/dot.png" alt="" />
      <img class="bg" src="../../assets/img/icon/sign/sign-up.png" alt="" />
      <img class="flower" src="../../assets/img/icon/sign/flower.png" alt="" />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 offset-xxl-2 col-xl-8 offset-xl-2">
          <div class="section__title-wrapper text-center mb-55">
            <h2 class="section__title">User Detail</h2>
            <p>I'm a subhead that goes with a story.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xxl-6 offset-xxl-3 col-xl-6 offset-xl-3 col-lg-8 offset-lg-2">
          <div class="sign__wrapper white-bg">
            <div class="sign__form">
              <form action="#">
                <div class="sign__input-wrapper mb-25">
                  <h5>Full Name</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Full name" />
                    <i class="fal fa-user"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Work email</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="e-mail address" />
                    <i class="fal fa-envelope"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Password</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Password" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-10">
                  <h5>Re-Password</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Re-Password" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <button class="e-btn w-100"><span></span> Sign Up</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'UserDetailArea',
};
</script>
